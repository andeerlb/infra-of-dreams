resource "aws_launch_template" "worker_node" {
  name                   = "eks-launch-template-test"
  update_default_version = true

  tag_specifications {
    resource_type = "instance"

    tags = merge(
      merge(var.default_tags, {
        Name = "${var.eks_cluster_name} ${local.node_name}"
    }), var.tags)
  }
} 