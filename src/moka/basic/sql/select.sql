SELECT
	id in (
		SELECT
			cr.id FROM moka.commentrelation as cr
		WHERE
			1 = 1
 		AND cr.commentId = 1
		AND cr.userId = 1
	), c.*
FROM
	moka. COMMENT AS c
WHERE
	1 = 1
AND c.lineId = 1
LIMIT 0,5;


SELECT ur.item_id ,r.* FROM zc_materiel_review.sys_user_role ur left join sys_role r using(role_id);