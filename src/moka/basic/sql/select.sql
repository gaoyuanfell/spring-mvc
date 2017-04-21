SELECT
	c.*, (
		SELECT
			COUNT(cr.id)
		FROM
			moka.commentrelation cr
		WHERE
			1 = 1
		AND cr.commentId = c.id
		AND cr.userId = 1
		AND cr.comType = 1
	) AS isPraised,
	(
		SELECT
			COUNT(cr.id)
		FROM
			moka.commentrelation cr
		WHERE
			1 = 1
		AND cr.commentId = c.id
		AND cr.userId = 1
		AND cr.comType = 3
	) AS isForward
FROM
	moka. COMMENT c
WHERE
	1 = 1
AND c.lineId = 1
LIMIT 0,
 5;




SELECT
	*
FROM
	(
		SELECT
			null,
			null,
			userId,
			title,
			introduce,
			privacy,
			praised,
			review,
			forward,
			createDate
		FROM
			line
		UNION
			SELECT
				lineId,
				context,
				userId,
				title,
				introduce,
				privacy,
				praised,
				review,
				forward,
				createDate
			FROM
				linesend
	) t