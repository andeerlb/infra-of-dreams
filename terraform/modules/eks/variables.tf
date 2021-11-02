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

variable "subnet_ids" {
  type = list(string)
}

variable "name" {
  type = string
}

variable "prefix" {
  type    = string
  default = ""
}

variable "endpoint_private_access" {
  type    = bool
  default = true
}

variable "endpoint_public_access" {
  type    = bool
  default = true
}

variable "public_access_cidrs" {
  type    = list(string)
  default = []
}

variable "engine_version" {
  type    = string
  default = ""
}