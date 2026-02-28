//public class Order {
//
//    public void processOrder(Order order) {
//        // High complexity due to deep nested structures and multiple conditional checks
//        if (order != null && order.getItems() != null) {
//            for (Item item : order.getItems()) {
//                if (item.getStock() > 0) {
//                    if (item.isDiscounted()) {
//                        System.out.println("Applying discount");
//                    }
//                    System.out.println("Processing item");
//                }
//            }
//        }
//    }
//
//    public void processOrder2(Order order){
//        if(order == null || order.getItems() == null){
//            return;
//        }
//
//        for(Item item: order.getItems()){
//            if(item.getStock() <= 0){
//                return;
//            }
//
//            if (item.isDiscounted()) {
//                System.out.println("Applying discount");
//            }
//            System.out.println("Processing item");
//
//
//        }
//    }
//}
