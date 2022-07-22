import io.fabric8.kubernetes.api.model.Namespaced
import io.fabric8.kubernetes.client.CustomResource
import io.fabric8.kubernetes.model.annotation.Group
import io.fabric8.kubernetes.model.annotation.Version

@Version("v1")
@Group("chorgi.io")
class PingServerResource : CustomResource<PingServerResourceSpec, PingServerResourceStatus>(), Namespaced {
    override fun initSpec(): PingServerResourceSpec {
        return PingServerResourceSpec()
    }

    override fun initStatus(): PingServerResourceStatus {
        return PingServerResourceStatus()
    }
}

class PingServerResourceStatus


class PingServerResourceSpec(var replicas: Int = 0)
