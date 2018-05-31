package com.yz.mvp_sample.annotation

//import java.lang.annotation.Documented
//import java.lang.annotation.Retention
//import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class PreActivity {
}