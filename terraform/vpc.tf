module "vpc" {
  source = "./modules/vpc"

  name = "iofd"
  azs  = ["us-east-1a", "us-east-1c"]
  cidr = "10.0.0.0/16"
  public_subnets = ["10.0.101.0/24", "10.0.102.0/24"]
  tags = {
    "kubernetes.io/cluster/${var.eks_cluster_name}" = "shared"
  }
}