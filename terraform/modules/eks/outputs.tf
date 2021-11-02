output "arn" {
  value = aws_eks_cluster.eks.arn
}

output "endpoint" {
  value = aws_eks_cluster.eks.endpoint
}

output "name" {
  value = aws_eks_cluster.eks.id
}

output "security_group_id" {
  value = aws_eks_cluster.eks.vpc_config[0].cluster_security_group_id
}