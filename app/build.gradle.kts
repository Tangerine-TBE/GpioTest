plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    signingConfigs {
        create("release") {
            storeFile = file("../platform.keystore") // keystore 文件路径
            storePassword = "611081" // keystore 密码
            keyAlias = "di_health" // 密钥别名
            keyPassword = "611081" // 密钥密码
            enableV2Signing = true
            enableV1Signing = true
        }
    }
    namespace = "cn.com.dihealth"
    compileSdk = 35

    defaultConfig {
        applicationId = "cn.com.dihealth"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    sourceSets {
        getByName("main") {
            java.srcDirs("src/main/java", "src/main/kotlin") // Specify Java and Kotlin source directories
            res.srcDirs("src/main/res")
            jniLibs.srcDirs("src/main/jniLibs")// Specify resources directory
            manifest.srcFile("src/main/AndroidManifest.xml") // Specify manifest file
        }
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = false
            isDebuggable=  false
        }
        debug {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = false
            isDebuggable=  true
            ndk {
                abiFilters.add("armeabi-v7a")
                abiFilters.add("x86")
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    externalNativeBuild {
        cmake {
            path = file("CMakeLists.txt")
            version = "3.22.1"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}