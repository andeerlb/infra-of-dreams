variable "default_tags" {
  type = map(string)
  default = {
    Terraform = "yes"
  }
}

variable "tags" {
  type    = map(string)
  default = {}
}

variable "eks_cluster_name" {
  type = string
}

variable "prefix" {
  type    = string
  default = ""
}

variable "name" {
  type = string
}

variable "max_unavailable" {
  type    = number
  default = 1
}

variable "desired_size" {
  type = number
}

variable "max_size" {
  type = number
}

variable "min_size" {
  type = number
}

variable "subnet_ids" {
  type = list(string)
}

variable "disk_size" {
  type    = number
  default = 10
}

variable "instance_types" {
  type    = list(string)
  default = ["t2.micro"]
}