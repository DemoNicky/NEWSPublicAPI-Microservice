-- Tabel db_article
CREATE TABLE db_article (
    id VARCHAR(255) NOT NULL,
    acc BOOLEAN,
    article_code VARCHAR(10),
    article_title VARCHAR(30),
    category_id VARCHAR(255),
    content VARCHAR(2500),
    image_id VARCHAR(255),
    article_like BIGINT(10),  -- Menggunakan tanda kutip untuk kata kunci
    posted_article TIMESTAMP(6),
    reader_ship INTEGER(4),
    user_code VARCHAR(255),
    PRIMARY KEY (id)
);

-- Tabel db_comment
CREATE TABLE db_comment (
    id VARCHAR(255) NOT NULL,
    article_code VARCHAR(255),
    comment_content VARCHAR(300),
    comment_post TIMESTAMP(6),
    diss_like BIGINT,
    comment_like BIGINT,  -- Menggunakan tanda kutip untuk kata kunci
    user_code VARCHAR(255),
    article_id VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- Tabel tb_comment_reply
CREATE TABLE tb_comment_reply (
    id VARCHAR(255) NOT NULL,
    reply_comment_content VARCHAR(300),
    reply_comment_post TIMESTAMP(6),
    reply_comment_like BIGINT,  -- Menggunakan tanda kutip untuk kata kunci
    diss_like BIGINT,  -- Menggunakan penamaan yang konsisten
    user_id VARCHAR(255),
    comment_id VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (comment_id) REFERENCES db_comment(id) ON DELETE CASCADE
);
