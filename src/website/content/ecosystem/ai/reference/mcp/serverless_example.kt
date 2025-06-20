package content.ecosystem.ai.reference.mcp

import org.http4k.ai.mcp.model.McpEntity
import org.http4k.ai.mcp.protocol.ServerMetaData
import org.http4k.ai.mcp.protocol.Version
import org.http4k.ai.mcp.server.security.NoMcpSecurity
import org.http4k.routing.bind
import org.http4k.routing.mcpHttpNonStreaming
import org.http4k.serverless.ApiGatewayV2LambdaFunction
import org.http4k.serverless.AppLoader

// This function is an AWS Lambda function.
class McpLambdaFunction : ApiGatewayV2LambdaFunction(AppLoader {
    mcpHttpNonStreaming(
        ServerMetaData(McpEntity.of("http4k mcp over serverless"), Version.of("0.1.0")),
        NoMcpSecurity,
        toolDefinitionFor("David") bind diaryToolHandler
    )
})
