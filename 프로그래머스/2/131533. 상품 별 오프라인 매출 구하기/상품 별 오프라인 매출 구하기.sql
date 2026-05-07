-- 코드를 입력하세요
SELECT p.product_code, (o.total_amount * p.price) AS sales
from product as p
join (
    select product_id, sum(sales_amount) as "total_amount"
    from offline_sale
    group by product_id
) as o
on p.product_id = o.product_id
order by 2 desc, 1 asc;