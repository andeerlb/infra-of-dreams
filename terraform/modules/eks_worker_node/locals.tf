locals {
  node_name = var.prefix == "" || var.prefix == null ? var.name : "${var.prefix} ${var.name}"

  aws-auth-cm = <<EOT
apiVersion: v1
kind: ConfigMap
metadata:
  name: aws-auth
  namespace: kube-system
data:
  mapRoles: |
    - rolearn: arn:aws:iam::335668809880:role/eks-node-group-wkteste
      username: system:node:{{EC2PrivateDNSName}}
      groups:
        - system:bootstrappers
        - system:nodes
EOT
}