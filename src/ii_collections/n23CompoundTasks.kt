package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product
    return customers.filter { it.orderedProducts.contains(product) }.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
    val deliveredOrders =  orders.filter { it.isDelivered }
    val products = deliveredOrders.flatMap { it.products }
    return products.maxBy { it.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
    val products = customers.flatMap { it.orders }.flatMap { it.products }
    val productsWithCount = products.groupBy { it }.mapValues { it.value.size }
    return productsWithCount.getOrDefault(product, 0)
}
