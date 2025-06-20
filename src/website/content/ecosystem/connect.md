---
title: http4k Connect
description: About the http4k Connect ecosystem.
ecosystem: http4k Connect
type: ecosystem
weight: 3
image: "/images/logo-connect.png"
---

http4k Connect is a lightweight API Client toolkit which includes libraries for connecting to popular third-party cloud
services and AI backends using [http4k](https://http4k.org) compatible APIs, along with Fake implementations for usage
during local testing. These are all underpinned by a variation on the
uniform [Server as a Function](https://monkey.org/~marius/funsrv.pdf) model powered by the `HttpHandler` interface
exposed by [http4k Core](https://www.http4k.org/ecosystem/http4k/), so you can:

1. Take advantage of the simple and powerful SaaF model and APIs used in http4k.
1. Plug everything together completely in-memory and take advantage of this powerful model.
1. Have access to the underlying HTTP clients (and hence add metrics or logging).
1. Run stateful Fake implementations of 3rd party systems locally or in test environments.

Although centered around usage in http4k-based projects, http4k-connect does not require this and the libraries are
usable from any JVM application.

## Rationale

Although convenient, many API Client libraries introduce many heavyweight dependencies or contain a plethora of
non-required functionality, which can have a large effect on binary size. As an alternative, http4k-connect provides
lightweight versions of popular APIs covering standard use-cases.

## Installation

```kotlin
dependencies {
    // install the platform...
    { { < http4k_bom > } }

    // ...then choose an API Client
    implementation("org.http4k:http4k-connect-amazon-s3")

    // ...and a storage backend (optional)
    implementation("org.http4k:http4k-connect-storage-redis")

    // ...a fake for testing (optional)
    testImplementation("org.http4k:http4k-connect-amazon-s3-fake")
}
```
