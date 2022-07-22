import io.fabric8.kubernetes.api.model.ConfigMap
import io.fabric8.kubernetes.api.model.Endpoints
import io.fabric8.kubernetes.client.KubernetesClient
import io.javaoperatorsdk.operator.api.reconciler.*
import javax.inject.Inject

@ControllerConfiguration(namespaces = [Constants.WATCH_CURRENT_NAMESPACE])
class PingServerReconciler(@Inject var kubernetesClient: KubernetesClient) : Reconciler<PingServerResource> {

    override fun reconcile(
        resource: PingServerResource,
        context: Context<PingServerResource>
    ): UpdateControl<PingServerResource> {
//        val map = context.getSecondaryResource(ConfigMap::class.java)?.filter {
//            it.metadata.name == "address-map"
//        }?.get()
        //val currentReplicas =  kubernetesClient.apps().deployments().inNamespace("kube-system").withName("pingpong").get().spec.replicas
        val replicas = resource.spec.replicas
//        if(currentReplicas < replicas) {
            kubernetesClient.apps().deployments().inNamespace("pp").withName("pingpong").scale(replicas, true)
//        }
//        kubernetesClient.apps.
        return UpdateControl.noUpdate()
    }
}