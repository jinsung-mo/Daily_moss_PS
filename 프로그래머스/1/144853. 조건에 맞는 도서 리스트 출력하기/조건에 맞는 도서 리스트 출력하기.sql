-- 코드를 입력하세요
select book_id, published_date
from book
where published_date >= '2021-01-01' and published_date < '2022-01-01' and category = '인문'
order by book_id asc;