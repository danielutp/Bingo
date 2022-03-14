CREATE SCHEMA IF NOT EXISTS bingo DEFAULT CHARACTER SET utf8 ;
USE bingo ;
-- -----------------------------------------------------
-- Table user
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS user (
  id_user INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  create_at DATE NULL,
  PRIMARY KEY (id_user))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table table_bingo
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS table_bingo (
  id_table_bingo INT NOT NULL AUTO_INCREMENT,
  id_bingo VARCHAR(5) NULL,
  numbers_bingo VARCHAR(5) NULL,
  PRIMARY KEY (id_table_bingo))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table game
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS game (
  id_game INT NOT NULL AUTO_INCREMENT, 
  table_bingo_id_table_bingo INT NOT NULL,
  create_at DATE NULL,
  winner VARCHAR(45) NULL,
  PRIMARY KEY (id_game),
  INDEX fk_game_table_bingo1_idx (table_bingo_id_table_bingo ASC) VISIBLE,
  CONSTRAINT fk_game_table_bingo1
    FOREIGN KEY (table_bingo_id_table_bingo)
    REFERENCES table_bingo (id_table_bingo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table table_user
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS table_user (
  id_table_gamer INT NOT NULL AUTO_INCREMENT,
  user_id_user INT NOT NULL,
  game_id_game INT NOT NULL,
  PRIMARY KEY (id_table_gamer),
  INDEX fk_table_user_user1_idx (user_id_user ASC) INVISIBLE,
  INDEX fk_table_user_game1_idx (game_id_game ASC) VISIBLE,
  UNIQUE INDEX id_table_gamer_UNIQUE (id_table_gamer ASC, user_id_user ASC) VISIBLE,
  CONSTRAINT fk_table_user_user1
    FOREIGN KEY (user_id_user)
    REFERENCES user (id_user)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_table_user_game1
    FOREIGN KEY (game_id_game)
    REFERENCES game (id_game)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table numbers
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS numbers (
  id_numbers INT NOT NULL AUTO_INCREMENT,
  numbers VARCHAR(5) NOT NULL,
  table_user_id_table_gamer INT NOT NULL,
  PRIMARY KEY (id_numbers),
  INDEX fk_numbers_table_user1_idx (table_user_id_table_gamer ASC) VISIBLE,
  CONSTRAINT fk_numbers_table_user1
    FOREIGN KEY (table_user_id_table_gamer)
    REFERENCES table_user (id_table_gamer)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table user_has_game
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS user_has_game (
  id_user_has_game INT NOT NULL,
  user_id_user INT NOT NULL,
  game_id_game INT NOT NULL,
  PRIMARY KEY (id_user_has_game),
  INDEX fk_user_has_game_game1_idx (game_id_game ASC) VISIBLE,
  INDEX fk_user_has_game_user1_idx (user_id_user ASC) VISIBLE,
  CONSTRAINT fk_user_has_game_user1
    FOREIGN KEY (user_id_user)
    REFERENCES user (id_user)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_user_has_game_game1
    FOREIGN KEY (game_id_game)
    REFERENCES game (id_game)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

insert into user_has_game(id_user_has_game,user_id_user,game_id_game)
value(1,1,1);
insert into user_has_game(id_user_has_game,user_id_user,game_id_game)
value(2,2,1);
insert into user_has_game(id_user_has_game,user_id_user,game_id_game)
value(3,3,1);

insert into user(id_user,name,create_at)
value(1,'Daniel',null);
insert into user(id_user,name,create_at)
value(2,'Martina',null);
insert into user(id_user,name,create_at)
value(3,'Paula',null);

insert into table_bingo(id_table_bingo,id_bingo,numbers_bingo)
value(1,1,5);
insert into table_bingo(id_table_bingo,id_bingo,numbers_bingo)
value(2,1,1);
insert into table_bingo(id_table_bingo,id_bingo,numbers_bingo)
value(3,1,14);

insert into game(id_game,table_bingo_id_table_bingo,create_at,winner)
value(1,1,null,null);
insert into game(id_game,table_bingo_id_table_bingo,create_at,winner)
value(2,2,null,null);
insert into game(id_game,table_bingo_id_table_bingo,create_at,winner)
value(3,3,null,null);

insert into table_user(id_table_gamer,user_id_user,game_id_game)
value(1,1,1);
insert into table_user(id_table_gamer,user_id_user,game_id_game)
value(2,2,1);
insert into table_user(id_table_gamer,user_id_user,game_id_game)
value(3,3,1);

insert into numbers(id_numbers,numbers,table_user_id_table_gamer)
value(1,14,1);
insert into numbers(id_numbers,numbers,table_user_id_table_gamer)
value(2,1,1);
insert into numbers(id_numbers,numbers,table_user_id_table_gamer)
value(3,4,1);