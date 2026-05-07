-- 코드를 입력하세요
SELECT distinct(c.car_id)
from car_rental_company_rental_history r
join car_rental_company_car c
on r.car_id = c.car_id
where c.car_type = '세단' and month(r.start_date) = 10
order by c.car_id desc;