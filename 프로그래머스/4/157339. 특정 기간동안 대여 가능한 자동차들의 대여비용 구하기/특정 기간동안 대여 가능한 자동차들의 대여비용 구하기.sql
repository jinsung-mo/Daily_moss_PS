-- 코드를 입력하세요
-- 세단 or suv / 20221101 ~ 20221130 / 50 <= car < 200
select c.car_id, c.car_type, (c.daily_fee * 30 * (100 - p.discount_rate) / 100) as 'fee'
from CAR_RENTAL_COMPANY_CAR c
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p on c.car_type = p.car_type
where 
    c.car_type in ('세단', 'suv')
    and p.duration_type = '30일 이상'
    and c.car_id not in (
        select car_id
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where end_date >= '2022-11-01' and start_date <= '2022-11-30'
    )
    and c.daily_fee * 30 * (100 - p.discount_rate) / 100 >= 500000
    and c.daily_fee * 30 * (100 - p.discount_rate) / 100 < 2000000
order by 3 desc, 2 asc, 1 desc;