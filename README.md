# Android Hello World — GitHub Actions CI

一个最小化 Android Kotlin 项目，展示如何使用 GitHub Actions 自动编译 APK。

## 工作流

推送到 `main` 分支 → GitHub Actions 自动编译 → 生成 APK artifact

## 技术栈

- Kotlin + Gradle (Kotlin DSL)
- Android Gradle Plugin 8.4.0
- JDK 17 / compileSdk 34 / minSdk 24

## 编译状态

![Build](https://github.com/baseredge/android-hello-world/actions/workflows/build.yml/badge.svg)

## 测试推送

此行用于测试云端推送功能。
