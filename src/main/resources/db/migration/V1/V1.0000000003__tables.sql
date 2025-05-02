ALTER TABLE car_photos DROP COLUMN photo_url;
ALTER TABLE car_photos ADD COLUMN photo_data BYTEA;
ALTER TABLE car_photos ADD COLUMN file_name VARCHAR(255);
