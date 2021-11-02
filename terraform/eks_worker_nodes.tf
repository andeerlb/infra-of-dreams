module "worker_node" {
    source = "./modules/eks_worker_node"

    eks_cluster_name = module.eks.name
    name = "wkteste"
    desired_size = 3
    max_size = 3
    min_size = 1
    subnet_ids = module.vpc.public_subnet_ids
}

output "aws_auth_cm" {
    value = module.worker_node.aws_auth_cm
}