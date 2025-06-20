---
category: Reference
type: ecosystem
ecosystem: http4k AI
title: "LangChain4J"
description: Feature overview of the http4k AI LangChain4J module
aliases:
    - /ecosystem/http4k/reference/langchain/
---

### Installation

```kotlin
dependencies {
    {{< http4k_bom >}}

    // for the LangChain4j model adapters
    implementation("org.http4k:http4k-connect-ai-langchain")
}
```

LangChain4J is a versatile library that simplifies the creation and management of language processing workflows., It provides many integrations but does not allow for using http4k clients or http4k-connect clients. This module gives you some of these integrations by providing LangChain model adapters.

Current adapters support http4k client integrations for the following models, allowing you to use them in your http4k applications:

- OpenAI
  - OpenAiChatLanguageModel
  - OpenAiChatImageModel
  - OpenAiChatEmbeddingModel
- Ollama
  - OllamaChatLanguageModel
  - OllamaChatImageModel
  - OllamaChatEmbeddingModel
- S3 Document Loaders

Using these adapters is as simple as:

```kotlin
val model: ChatLanguageModel = OpenAiChatLanguageModel(OpenAI.Http(OpenAIToken.of("hello"), FakeOpenAI()))
val chat: Response<AiMessage> = model.generate("hello kitty")
```
