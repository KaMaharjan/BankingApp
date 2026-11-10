INSERT INTO	 customers (first_name, last_name, email, phone)
VALUES
    ('John', 'Doe', 'john.doe@example.com', '555-123-4567'),
    ('Jane', 'Smith', 'jane.smith@example.com', '555-234-5678'),
    ('Michael', 'Johnson', 'michael.johnson@example.com', '555-345-6789'),
    ('Emily', 'Davis', 'emily.davis@example.com', '555-456-7890'),
    ('David', 'Wilson', 'david.wilson@example.com', '555-567-8901'),
    ('Sarah', 'Brown', 'sarah.brown@example.com', '555-678-9012'),
    ('James', 'Taylor', 'james.taylor@example.com', '555-789-0123'),
    ('Olivia', 'Anderson', 'olivia.anderson@example.com', '555-890-1234'),
    ('Daniel', 'Thomas', 'daniel.thomas@example.com', '555-901-2345'),
    ('Sophia', 'Martinez', 'sophia.martinez@example.com', '555-012-3456')
    ON CONFLICT (email) DO NOTHING;