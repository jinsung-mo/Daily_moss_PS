-- 코드를 입력하세요
select pt_name, pt_no, gend_cd, age, ifnull(tlno, 'NONE') as tlno
from patient
where age < 13 and gend_cd = 'w'
order by age desc, pt_name asc;