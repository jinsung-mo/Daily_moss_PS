-- 코드를 입력하세요
SELECT order_id, product_id, out_date,
    case
        when cast(out_date as signed) <= 20220501 then '출고완료'
        when cast(out_date as signed) > 20220501 then '출고대기'
        else '출고미정'
    end as '출고여부'
from food_order
order by 1 asc;