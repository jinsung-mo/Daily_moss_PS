-- 코드를 입력하세요
SELECT h.flavor
from first_half h
join july j
on h.FLAVOR = j.FLAVOR
group by h.flavor
order by (h.total_order + sum(j.total_order)) desc
limit 3;
