select a.flavor
from first_half as a
join icecream_info as b
on a.flavor = b.flavor
where a.total_order >= 3000 and b.ingredient_type like "fruit%"
order by total_order desc;


-- 코드를 입력하세요
SELECT flavor
from first_half
where total_order >= 3000 and flavor in (select flavor from icecream_info where ingredient_type like "fruit%")
order by total_order desc;