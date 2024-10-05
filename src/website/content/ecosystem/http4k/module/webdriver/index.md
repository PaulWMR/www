---
layout: module
type: module
ecosystem: http4k Core
title: Webdriver
description: Feature overview of the http4k-testing-webdriver module
---


### Installation (Gradle)

```kotlin
dependencies {
    {{< http4k_bom>}}
    implementation("org.http4k:http4k-testing-webdriver")
}
```

### About

A basic Selenium WebDriver API implementation for http4k HttpHandlers, which runs completely out of container (no network) for ultra fast tests, backed by JSoup.

| Feature | Supported | Notes |
|---------|-----------|-------|
| Navigation|yes|simple back/forward/refresh history|
| CSS selectors|yes||
| Link navigation|yes||
| Form field entry and submission|yes||
| Cookie storage|yes|manual expiry management|
| JavaScript|no||
| Alerts|no||
| Screenshots|no||
| Frames|no||
| Multiple windows|no||

Use the API like any other WebDriver implementation, by simply passing your app HttpHandler to construct it.

#### Code

{{< kotlin file="example.kt" >}}

[http4k]: https://http4k.org
