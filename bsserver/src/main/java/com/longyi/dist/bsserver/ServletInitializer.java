package com.longyi.dist.bsserver;

/**
 * Created by chenglongwei on 9/17/15.
 */

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

// Needed for war
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DistThingsApplication.class);
    }

}
