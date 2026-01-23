/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import models.DBManager;
import models.Product;

/**
 *
 * @author 30471297
 */
public class SearchSortProducts extends javax.swing.JFrame {
    
    // Logger for reporting errors or runtime issues
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SearchSortProducts.class.getName());
    // Model used by JList to display product names and prices
    private DefaultListModel <String> model= new DefaultListModel<>();
    // Holds the list of Product objects loaded from the database
    private ArrayList<Product> products = new ArrayList<>();
    
    /**
     * Creates new form SearchSortProducts
     * 
     * 
     */
    public SearchSortProducts() {
        initComponents();
        // Attach the model to the visible JList component
        lstProducts.setModel(model);
        //Disable binary search until list has been sorted
        btnBinarySearch.setEnabled(false); // search is not available till the list is sorted
        
        loadAllProducts();// Load products from the database
        displayProducts();  
    }

    private void loadAllProducts() {
        //Loads all products from the database using DBManager
        DBManager db = new DBManager(); // fix imports
        products = db.loadProducts();
        
    }
    //Bubble Sort implementation: sorts products by price 
    private void bubbleSortProducts(){
        int totalProducts = products.size();

    for (int pass = 0; pass < totalProducts - 1; pass++) {
        boolean didSwap = false;//each pass moves largest item to the end
        //Compare each pair
        for (int index = 0; index < totalProducts - pass - 1; index++) {
            if (products.get(index).getPrice() > products.get(index + 1).getPrice()) {
                // Swap the products
                Product currentProduct = products.get(index);//Swap the products
                products.set(index, products.get(index + 1));
                products.set(index + 1, currentProduct);
                didSwap = true;
            }
        }

        // Stop early if no swaps occurred
        if (!didSwap)
            break;
    }
    }
    
    // Method: Selection Sort in Ascending Order by Product Price
    private void sortProductsByPriceAscending() {
    int totalProducts = products.size();

    // Loop through each product except the last one
    for (int currentIndex = 0; currentIndex < totalProducts - 1; currentIndex++) {
        int lowestPriceIndex = currentIndex;

        // Find the product with the lowest price in the remaining list
        for (int compareIndex = currentIndex + 1; compareIndex < totalProducts; compareIndex++) {
            if (products.get(compareIndex).getPrice() < products.get(lowestPriceIndex).getPrice()) {
                lowestPriceIndex = compareIndex;
            }
        }

        // Swap the current product with the product that has the lowest price
        if (lowestPriceIndex != currentIndex) {
            Product tempProduct = products.get(currentIndex);
            products.set(currentIndex, products.get(lowestPriceIndex));
            products.set(lowestPriceIndex, tempProduct);
        }
    }
}
    
    // Method: Linear Search for Products by Price
    private void linearSearch(double priceToFind) {
    model.clear(); // Clear previous search results
    boolean isProductFound = false;

    // Iterate through the list of products
    for (Product productItem : products) {
        if (productItem.getPrice() == priceToFind) {
            // Add matching product to the display model
            model.addElement(productItem.getProductName() + " - £" + productItem.getPrice());
            isProductFound = true;
        }
    }

    // If no product matches the price, show a message
    if (!isProductFound) {
        model.addElement("No product found with price £" + priceToFind);
    }
}
    
    
    // Method: Binary Search for Products by Price
    private void binarySearch(double priceToFind) {
    model.clear();

    int lowIndex = 0;
    int highIndex = products.size() - 1;

    while (lowIndex <= highIndex) {
        int middleIndex = (lowIndex + highIndex) / 2;
        double middlePrice = products.get(middleIndex).getPrice();

        if (middlePrice == priceToFind) {
            Product matchedProduct = products.get(middleIndex);
            model.addElement(matchedProduct.getProductName() + " — £" + matchedProduct.getPrice());
            return;
        } else if (middlePrice < priceToFind) {
            lowIndex = middleIndex + 1;      // search right half
        } else {
            highIndex = middleIndex - 1;     // search left half
        }
    }

    model.addElement("No products found at price £" + priceToFind);
}
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBubbleSort = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstProducts = new javax.swing.JList<>();
        btnSelectionSort = new javax.swing.JButton();
        btnLinearSearch = new javax.swing.JButton();
        btnBinarySearch = new javax.swing.JButton();
        lblProductPrice = new javax.swing.JLabel();
        txtProductPrice = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBubbleSort.setBackground(new java.awt.Color(255, 255, 204));
        btnBubbleSort.setText("Bubble Sort");
        btnBubbleSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBubbleSortActionPerformed(evt);
            }
        });

        lstProducts.setBackground(new java.awt.Color(204, 255, 204));
        jScrollPane1.setViewportView(lstProducts);

        btnSelectionSort.setBackground(new java.awt.Color(255, 255, 204));
        btnSelectionSort.setText("Selection Sort");
        btnSelectionSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectionSortActionPerformed(evt);
            }
        });

        btnLinearSearch.setBackground(new java.awt.Color(255, 255, 204));
        btnLinearSearch.setText("Linear Search");
        btnLinearSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLinearSearchActionPerformed(evt);
            }
        });

        btnBinarySearch.setBackground(new java.awt.Color(255, 255, 204));
        btnBinarySearch.setText("Binary Search");
        btnBinarySearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBinarySearchActionPerformed(evt);
            }
        });

        lblProductPrice.setBackground(new java.awt.Color(255, 255, 204));
        lblProductPrice.setText("Enter Product Price");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBubbleSort)
                        .addGap(18, 18, 18)
                        .addComponent(btnSelectionSort)))
                .addContainerGap(117, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLinearSearch)
                        .addGap(44, 44, 44)
                        .addComponent(btnBinarySearch))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBubbleSort)
                    .addComponent(btnSelectionSort)
                    .addComponent(lblProductPrice)
                    .addComponent(txtProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBinarySearch)
                    .addComponent(btnLinearSearch))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBubbleSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBubbleSortActionPerformed
    //stage 12
    
    bubbleSortProducts();
    displayProducts();
    btnBinarySearch.setEnabled(true);
    
    }                                             
    
    private void displayProducts()
    {
        model.clear();
        for(Product p: products)
        {
            model.addElement(p.getProductName() + " -£" +p.getPrice());
        }
    
    }//GEN-LAST:event_btnBubbleSortActionPerformed

    private void btnSelectionSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectionSortActionPerformed
    // stage 13
    
     sortProductsByPriceAscending();
     displayProducts();
     btnBinarySearch.setEnabled(true);


    
    }//GEN-LAST:event_btnSelectionSortActionPerformed

    private void btnLinearSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLinearSearchActionPerformed
    // stage 14
        try {
        double priceToSearch = Double.parseDouble(txtProductPrice.getText());
        linearSearch(priceToSearch);
    } catch (NumberFormatException e) {
        model.clear();
        model.addElement("Please enter valid price.");
    }
    }//GEN-LAST:event_btnLinearSearchActionPerformed

    private void btnBinarySearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBinarySearchActionPerformed
   // stage 14                                              
    try {
        double priceToSearch = Double.parseDouble(txtProductPrice.getText());
        binarySearch(priceToSearch);
    } catch (NumberFormatException e) {
        model.clear();
        model.addElement("Please enter valid price.");
    }
    }//GEN-LAST:event_btnBinarySearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        //java.awt.EventQueue.invokeLater(() -> new SearchSortProducts().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBinarySearch;
    private javax.swing.JButton btnBubbleSort;
    private javax.swing.JButton btnLinearSearch;
    private javax.swing.JButton btnSelectionSort;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblProductPrice;
    private javax.swing.JList<String> lstProducts;
    private javax.swing.JTextField txtProductPrice;
    // End of variables declaration//GEN-END:variables
}
