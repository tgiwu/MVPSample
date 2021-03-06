package com.yz.mvp_sample.annotation

import javax.inject.Scope
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

@Scope
@MustBeDocumented
@Retention(RetentionPolicy.RUNTIME)
annotation class AppScope {
}