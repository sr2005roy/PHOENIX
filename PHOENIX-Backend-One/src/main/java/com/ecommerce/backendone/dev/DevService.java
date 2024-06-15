package com.ecommerce.backendone.dev;

import com.ecommerce.backendone.entity.Category;
import com.ecommerce.backendone.entity.Product;
import com.ecommerce.backendone.entity.Section;
import com.ecommerce.backendone.repository.CategoryRepository;
import com.ecommerce.backendone.repository.ProductRepository;
import com.ecommerce.backendone.repository.ReviewRepository;
import com.ecommerce.backendone.repository.SectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DevService {
    @Autowired
    private final ReviewRepository reviewRepository;
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final CategoryRepository categoryRepository;
    @Autowired
    private final SectionRepository sectionRepository;

    public boolean resetDatabase() {
        try {
            reviewRepository.resetSequence();
            productRepository.resetSequence();
            categoryRepository.resetSequence();
            sectionRepository.resetSequence();

            reviewRepository.deleteAll();
            productRepository.deleteAll();
            categoryRepository.deleteAll();
            sectionRepository.deleteAll();

            Section section;
            for (String data : DatabaseBackup.sectionData) {
                section = new Section();
                section.setSectionName(data);
                sectionRepository.save(section);
            }

            Category category;
            for (String[] data : DatabaseBackup.categoryData) {
                section = new Section();
                section.setSectionId(Integer.parseInt(data[0]));
                category = new Category();
                category.setCategoryName(data[1]);
                category.setSection(section);
                category.setImageUrl(data[2]);
                categoryRepository.save(category);
            }

            Product product;
            String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sed nunc tortor. Sed tellus nunc, fringilla a tristique et, egestas in ex. Ut ut dui sit amet enim ornare posuere a vel justo. Morbi lorem purus, vulputate ut maximus id, pretium eget sem. Vestibulum sit amet pretium lectus. Mauris non lorem erat. Mauris et nulla eget metus maximus consequat. Ut eget ligula at velit porta posuere non quis neque. Donec dignissim ornare egestas. Quisque id libero finibus, sagittis arcu id, ultrices mauris. Sed pellentesque vulputate velit ut tempor. Nunc a lectus bibendum lectus sollicitudin posuere. Sed ultrices eu nisl vel ullamcorper. Aliquam scelerisque luctus odio sollicitudin posuere.";
            for (int i = 0; i < DatabaseBackup.productData.length; i++) {
                String[] data = DatabaseBackup.productData[i];
                category = new Category();
                category.setCategoryId(Integer.parseInt(data[0]));
                product = new Product();
                product.setProductName(data[1]);
                product.setImageUrl(data[2]);
                product.setCategory(category);
                data = DatabaseBackup.productPriceData[i];
                product.setMarkedPrice(Integer.parseInt(data[0]));
                product.setSellingPrice(Integer.parseInt(data[1]));
                product.setDescription(description);
                product.setReviewCount(0);
                product.setTotalRating(0);
                productRepository.save(product);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
