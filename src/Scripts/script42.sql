ALTER TABLE student ADD CONSTRAINT age_constraint CHECK (age > 16);
ALTER TABLE student ADD CONSTRAINT name_constraint_unique UNIQUE(name);
ALTER TABLE student ADD CONSTRAINT name_constraint_filled CHECK (name != '');
ALTER TABLE faculty ADD constraint color_constraint_unique UNIQUE(color);

