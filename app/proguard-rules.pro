# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-verbose

# Optimization is turned off by default. Dex does not like code run # through the ProGuard optimize and preverify steps (and performs #some of these optimizations on its own).
-optimizations !code/simplification/arithmetic,!code/simplification/cast,!field/*,!class/merging/*
-optimizations !method/inlining/*
-optimizationpasses 5
-allowaccessmodification
-assumenosideeffects class android.util.Log {
public static *** d(...);
public static *** i(...);
public static *** v(...);
}

#class
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
   public *;
}
-dontwarn android.support.**
-dontwarn com.google.**


-keep class * implements android.os.Parcelable {
   public static final android.os.Parcelable$Creator *;
}

-keep class * implements java.io.Serializable { *; }

# Application classes that will be serialized/deserialized over Gson
-keep class com.spectraverse.spectraverse.models.** { *; }

# Gson specific classes
-keep class sun.misc.Unsafe { *; }
#-keep class com.google.gson.stream.** { *; }
-keepattributes Signature
# For using GSON @Expose annotation
-keepattributes *Annotation*
# Gson specific classes

-dontwarn android.support.v4.**
-dontwarn com.google.android.**
-dontwarn com.android.volley.**
-dontwarn android.support.v7.**

# support design
-dontwarn android.support.design.**
-keep class android.support.design.** { *; }
-keep interface android.support.design.** { *; }
-keep public class android.support.design.R$* { *; }

-keepattributes SourceFile,LineNumberTable