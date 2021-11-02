resource "aws_eks_node_group" "eks_workder_node" {
  cluster_name    = var.eks_cluster_name
  node_group_name = local.node_name
  node_role_arn   = aws_iam_role.worker_node.arn
  subnet_ids      = var.subnet_ids
  instance_types  = var.instance_types

  launch_template {
    id      = aws_launch_template.worker_node.id
    version = "$Latest"
  }

  scaling_config {
    desired_size = var.desired_size
    max_size     = var.max_size
    min_size     = var.min_size
  }

  update_config {
    max_unavailable = var.max_unavailable
  }

  depends_on = [
    aws_iam_role_policy_attachment.worker_node_AmazonEKSWorkerNodePolicy,
    aws_iam_role_policy_attachment.worker_node_AmazonEKS_CNI_Policy,
    aws_iam_role_policy_attachment.worker_node_AmazonEC2ContainerRegistryReadOnly
  ]

  tags = merge(var.default_tags, var.tags)
}