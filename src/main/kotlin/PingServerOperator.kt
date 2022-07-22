import io.javaoperatorsdk.operator.Operator
import io.quarkus.runtime.Quarkus
import io.quarkus.runtime.QuarkusApplication
import io.quarkus.runtime.annotations.QuarkusMain

@QuarkusMain
class PingServerOperator(val operator: Operator) : QuarkusApplication {
    @Throws(Exception::class)
    override fun run(vararg args: String): Int {
        operator.start()
        Quarkus.waitForExit()
        return 0
    }

}

fun main(args: Array<String>) {
    Quarkus.run(PingServerOperator::class.java, *args)
}