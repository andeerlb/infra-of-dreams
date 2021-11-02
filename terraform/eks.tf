module "eks" {
    source = "./modules/eks"

    name = var.eks_cluster_name
    subnet_ids = module.vpc.public_subnet_ids
    public_access_cidrs = ["179.162.116.67/32"]
}