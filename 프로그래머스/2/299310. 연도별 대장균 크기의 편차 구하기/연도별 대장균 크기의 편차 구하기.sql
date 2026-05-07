-- 코드를 작성해주세요
select year(a.differentiation_date) as year, (b.max_size - a.size_of_colony) as year_dev, a.id
from ecoli_data as a
join (
    select YEAR(differentiation_date) as year, max(size_of_colony) as max_size
    from ecoli_data
    group by YEAR(differentiation_date)
) as b
on YEAR(a.differentiation_date) = b.year
order by year asc, year_dev asc;