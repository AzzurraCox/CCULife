package org.zankio.ccudata.base.source.annotation;

import org.zankio.ccudata.base.source.SourceProperty;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Important {
    SourceProperty.Level value();
}
