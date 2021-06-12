package kr.mjc.sehyuckpark.web;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.descriptor.web.JspConfigDescriptorImpl;
import org.apache.tomcat.util.descriptor.web.JspPropertyGroup;
import org.apache.tomcat.util.descriptor.web.JspPropertyGroupDescriptorImpl;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

import javax.servlet.descriptor.JspConfigDescriptor;
import javax.servlet.descriptor.JspPropertyGroupDescriptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

@Component
@Slf4j
public class TomcatServerCustomizer
        implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        Collection<TomcatContextCustomizer> col = new ArrayList<>();
        col.add((context) -> {
            JspPropertyGroup jspPropertyGroup = new JspPropertyGroup();
            jspPropertyGroup.addUrlPattern("*.jsp");
            jspPropertyGroup.addUrlPattern("*.html");
            jspPropertyGroup.setPageEncoding("UTF-8");
            JspPropertyGroupDescriptor jspPropertyGroupDescriptor =
                    new JspPropertyGroupDescriptorImpl(jspPropertyGroup);

            Collection<JspPropertyGroupDescriptor> jspPropertyGroupDescriptors =
                    new HashSet<>();
            jspPropertyGroupDescriptors.add(jspPropertyGroupDescriptor);

            JspConfigDescriptor jspConfigDescriptor =
                    new JspConfigDescriptorImpl(jspPropertyGroupDescriptors,
                            new HashSet<>());
            context.setJspConfigDescriptor(jspConfigDescriptor);

            context.addWelcomeFile("/index.jsp");
            context.addWelcomeFile("/index.jsp");
        });
        factory.setTomcatContextCustomizers(col);
        log.info("Run Tomcat Customizer");
    }
}