CREATE TABLE IF NOT EXISTS public.board_tbl (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    writer VARCHAR(100) NOT NULL,
    pass VARCHAR(100) NOT NULL,
    contents TEXT NOT NULL
);

INSERT INTO public.board_tbl (title, writer, pass, contents)
VALUES ('테스트 제목', '작성자', '1234', '테스트 내용입니다');