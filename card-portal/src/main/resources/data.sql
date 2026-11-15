INSERT INTO cards (brand, last4, holder_name, type, status, balance, credit_limit) VALUES
('VISA',       '4821', 'PANAGIOTIS ANTONIOU', 'CREDIT', 'ACTIVE', 320.50, 2000.00),
('MASTERCARD', '0912', 'PANAGIOTIS ANTONIOU', 'DEBIT',  'ACTIVE', 1450.00, 0.00),
('VISA',       '7734', 'PANAGIOTIS ANTONIOU', 'CREDIT', 'FROZEN', 0.00,   5000.00);

INSERT INTO transactions (card_id, merchant, amount, currency, date_time, status, disputed) VALUES
(1, 'Starbucks Nicosia', 4.50,  'EUR', '2026-11-12 08:15:00', 'APPROVED', FALSE),
(1, 'Alphamega',         32.10, 'EUR', '2026-11-11 18:40:00', 'APPROVED', FALSE),
(1, 'Amazon',            89.99, 'EUR', '2026-11-10 21:05:00', 'PENDING',  FALSE),
(1, 'Unknown Merchant',  250.00,'EUR', '2026-11-09 03:12:00', 'DECLINED', FALSE),
(2, 'Wolt',              18.40, 'EUR', '2026-11-12 20:30:00', 'APPROVED', FALSE),
(2, 'Cyta',              45.00, 'EUR', '2026-11-05 10:00:00', 'APPROVED', FALSE),
(2, 'Mall of Cyprus',    120.00,'EUR', '2026-11-01 16:20:00', 'APPROVED', FALSE);