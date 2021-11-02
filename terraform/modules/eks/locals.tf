locals {
  cluster_name = var.prefix == "" || var.prefix == null ? var.name : "${var.prefix} ${var.name}"
}