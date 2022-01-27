package syscon.restapijpaservice.common.config;

import net.rakugakibox.util.YamlResourceBundle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver slr = new SessionLocaleResolver();    // 세션 기반 Locale 정보 변경
        slr.setDefaultLocale(Locale.KOREAN);    // lang 값이 없으면 기본으로 한국어 제공
        return slr;
    }

    /**
     * spring 공식 국제화 처리 인터셉터
     */
    @Bean
    LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(localeChangeInterceptor()); // 시스템 레지스트리에 추가
    }


    @Bean
    public MessageSource messageSource(
            @Value("${spring.messages.basename}") String basename,
            @Value("${spring.messages.encoding") String encoding) {

        YamlMessageSource ms = new YamlMessageSource();
        ms.setBasenames(basename);
        ms.setDefaultEncoding(encoding);
        ms.setAlwaysUseMessageFormat(true); // 메시지 포맷을 전체 메시지에 적용
        ms.setUseCodeAsDefaultMessage(true);    // 메시지를 찾지 못하면 예외처리 대신 메시지 코드를 그대로 반환
        ms.setFallbackToSystemLocale(true); // 감지된 locale 파일이 없으면 system locale값 사용
        return ms;
    }

    // locale 조합에 맞게 파일을 읽음
    private static class YamlMessageSource extends ResourceBundleMessageSource{
        @Override
        protected ResourceBundle doGetBundle(String basename, Locale locale) throws MissingResourceException {
            return ResourceBundle.getBundle(basename, locale, YamlResourceBundle.Control.INSTANCE);
        }
    }
}