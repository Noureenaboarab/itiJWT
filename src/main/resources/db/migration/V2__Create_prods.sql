CREATE TABLE IF NOT EXISTS products (
    product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(1000),
    price DECIMAL(19,2) NOT NULL,
    stock INT NOT NULL,
    category VARCHAR(255) NOT NULL,
    image_url VARCHAR(1000),
    active BOOLEAN NOT NULL
);

INSERT INTO products (product_id,name, description, price, stock, category, image_url, active) VALUES
(
    1,
    'Classic White T-Shirt',
    'Premium cotton classic fit white t-shirt. Comfortable for everyday wear.',
    19.99, 150, 'T-Shirts',
    'https://images.unsplash.com/photo-1521572163474-6864f9cf17ab',
    TRUE
),
(
    2,
    'Slim Fit Jeans',
    'Modern slim fit denim jeans in dark wash. Stretch fabric for comfort.',
    59.99, 80, 'Jeans',
    'https://images.unsplash.com/photo-1542272604-787c3835535d',
    TRUE
),
(
    3,
    'Running Sneakers',
    'Lightweight running shoes with responsive cushioning and breathable mesh upper.',
    89.99, 60, 'Shoes',
    'https://images.unsplash.com/photo-1542291026-7eec264c27ff',
    TRUE
),
(
    4,
    'Leather Jacket',
    'Genuine leather biker jacket with zip pockets. Classic style meets durability.',
    199.99, 30, 'Jackets',
    'https://images.unsplash.com/photo-1551028719-00167b16eac5',
    TRUE
),
(
    5,
    'Floral Summer Dress',
    'Light and breezy floral print dress. Perfect for warm weather occasions.',
    44.99, 90, 'Dresses',
    'https://images.unsplash.com/photo-1572804013309-59a88b7e92f1',
    TRUE
),
(
    6,
    'Wool Sweater',
    'Cozy merino wool sweater in classic crew neck style. Available in multiple colors.',
    79.99, 50, 'Sweaters',
    'https://images.unsplash.com/photo-1620799140408-edc6dcb6d633',
    TRUE
),
(
    7,
    'Chino Pants',
    'Versatile slim fit chino trousers. Great for casual and smart casual looks.',
    49.99, 70, 'Pants',
    'https://images.unsplash.com/photo-1473966968600-fa801b869a1a',
    TRUE
),
(
    8,
    'Baseball Cap',
    'Adjustable cotton baseball cap with embroidered logo. One size fits all.',
    24.99, 200, 'Accessories',
    'https://images.unsplash.com/photo-1588850561407-ed78c282e89b',
    TRUE
),
(
    9,
    'Canvas Tote Bag',
    'Durable canvas tote bag with inside zip pocket. Eco-friendly everyday bag.',
    29.99, 120, 'Accessories',
    'https://images.unsplash.com/photo-1544816155-12df9643f363',
    TRUE
),
(
    10,
    'Polo Shirt',
    'Classic pique polo shirt with ribbed collar. Perfect for smart casual occasions.',
    34.99, 100, 'Shirts',
    'https://images.unsplash.com/photo-1598032895397-b9472444bf93',
    FALSE  -- inactive product example
);