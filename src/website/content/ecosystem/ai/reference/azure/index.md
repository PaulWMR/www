---
category: Reference
type: ecosystem
ecosystem: http4k AI
title: "AzureAI"
description: Feature overview of the http4k AI Azure modules
aliases:
    - /ecosystem/http4k/reference/azure/
---


### Installation

```kotlin
dependencies {
    {{< http4k_bom >}}

    // for the Universal LLM adapter (uses the OpenAI fake)
    implementation("org.http4k:http4k-ai-llm-azure")
    implementation("org.http4k:http4k-connect-openai-fake")

    // for the low-level Azure API client
    implementation("org.http4k:http4k-connect-ai-azure")
    implementation("org.http4k:http4k-connect-ai-azure-fake")
}
```

The http4k-ai AzureAI integration provides:

- Universal LLM adapter for AzureAI and AzureGitHubModels
- Low-level AzureAI API Client
- Compatibility with GitHubModels for testing, so you can use a GitHub ApiKey instead of a deployed Azure model. Note that some endpoints are not available in GitHubModels APIs.
- FakeAzureAI server which can be used as testing harness for the API Client 

## Universal LLM adapter

The Universal LLM adapter converts the http4k LLM interface into the underlying API, allowing you to swap out providers without changing your application code.

{{< kotlin file="universal_adapter.kt" >}}

## Low-level API Client

The AzureAI connector provides the following Actions:

* GetInfo
* ChatCompletions
* Completions
* CreateEmbeddings

New actions can be created easily using the same transport.

The client APIs utilise the AzureAI API Key (Bearer Auth). There is no reflection used anywhere in the library, so
this is perfect for deploying to a Serverless function.

### Example usage

```kotlin
    // create a client
val client = AzureAI.Http(
    AzureAIApiKey.of("foobar"),
    AzureHost.of("myHost"), Region.of("us-east-1"),
    http.debug()
)

// all operations return a Result monad of the API type
val result: Result<Sequence<CompletionResponse>, RemoteFailure> = client
    .chatCompletion(ModelName.of("Meta-Llama-3.1-70B-Instruct"), listOf(Message.User("good afternoon"))), 1000, true)

println(result.orThrow().toList())
}
```

Other examples can be found [here](https://github.com/http4k/http4k-connect/tree/master/ai/azure/fake/src/examples/kotlin).

## Fake AzureAI Server

The Fake AzureAI provides the below actions and can be spun up as a server, meaning it is perfect for using in test
environments without using up valuable request tokens!

* GetInfo
* ChatCompletions
* Completions
* CreateEmbeddings

### Security

The Fake server endpoints are secured with a BearerToken header, but the value is not checked for anything other than presence.

### Generation of responses

By default, a random LoremIpsum generator creates chat completion responses for the Fake. This behaviour can be
overridden to generate custom response formats (eg. structured responses) if required. To do so, create instances of
the `ChatCompletionGenerator` interface and return as appropriate.

### Default Fake port: 14504

To start:

```kotlin
FakeAzureAI().start()
```
