-- Department 데이터 삽입
INSERT INTO department(departmentpk, is_deleted, name)
VALUES
    (1, false, '인사부'),
    (2, false, '재무부'),
    (3, false, '마케팅부'),
    (4, false, '개발부')
ON CONFLICT (departmentpk) DO NOTHING;
-- Position 데이터 삽입
INSERT INTO position(positionpk, is_deleted, name)
VALUES
    (1, false, '사원'),
    (2, false, '대리'),
    (3, false, '과장'),
    (4, false, '부장')
ON CONFLICT (positionpk) DO NOTHING;

INSERT INTO users (userpk, account, password, email, phone_number, name, is_active,
                   last_changed_password, password_expired, check_admin, check_guest, department_pk,
                   position_pk, created_date, updated_date, is_deleted)
SELECT nextval('users_id_seq'), t.*
FROM (
         VALUES
             ('user001', '111111111', 'user001@naver.com', '010-1111-1111', '일반 사용자', false, NOW(), false, false, false, 1, 1, NOW(), NOW(), false),
             ('admin001', '111111111', 'admin001@naver.com', '010-4315-1158', '관리자', false, NOW(), false, true, false, 2, 2, NOW(), NOW(), false)
     ) AS t(account, password, email, phone_number, name, is_active, last_changed_password, password_expired, check_admin, check_guest, department_pk, position_pk, created_date, updated_date, is_deleted)
WHERE NOT EXISTS (
          SELECT 1
          FROM users u
          WHERE u.account = t.account);

-- geust_request

INSERT INTO guest_request (guest_request_pk, create_date,update_date)
VALUES
    ('1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('3', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)
    ON CONFLICT (guest_request_pk) DO NOTHING;

-- project

INSERT INTO project (project_pk, create_date, description, end_date, is_deleted, name, priority, start_date, status, update_date, guest_request_pk)
VALUES
    ('1', CURRENT_TIMESTAMP, '새로운 웹사이트 개발', '2024-12-31', false, '웹 리뉴얼 프로젝트', 'high', '2024-01-01', 1, CURRENT_TIMESTAMP, '1'),
    ('2', CURRENT_TIMESTAMP, '모바일 앱 업데이트', '2024-09-30', false, '앱 2.0 업그레이드', 'medium', '2024-03-01', 1, CURRENT_TIMESTAMP, '1'),
    ('3', CURRENT_TIMESTAMP, '데이터 분석 시스템 구축', '2025-06-30', false, '빅데이터 분석 프로젝트', 'high', '2024-07-01', 1, CURRENT_TIMESTAMP, '2'),
    ('4', CURRENT_TIMESTAMP, '고객 지원 시스템 개선', '2024-08-31', false, '고객 서비스 향상 프로젝트', 'low', '2024-02-01', 1, CURRENT_TIMESTAMP, '2'),
    ('5', CURRENT_TIMESTAMP, '인공지능 챗봇 개발', '2025-03-31', false, 'AI 고객 상담 프로젝트', 'medium', '2024-04-01', 1, CURRENT_TIMESTAMP, '2')
    ON CONFLICT (project_pk) DO NOTHING;
-- task

INSERT INTO task (task_pk, created_date, description, end_date, name, priority, start_date, status, parent_task_pk, project_pk, is_deleted)
VALUES
    ('1', CURRENT_TIMESTAMP, '요구사항 분석', '2024-02-15', '요구사항 정의', 1, '2024-01-01', 2,  NULL, '1', false),
    ('2', CURRENT_TIMESTAMP, '데이터베이스 설계', '2024-03-01', 'DB 모델링', 2, '2024-02-16', 1,  '1', '1', false ),
    ('3', CURRENT_TIMESTAMP, '프론트엔드 개발', '2024-04-30', 'UI 구현', 2, '2024-03-02', 1,  '1', '1', false),
    ('4', CURRENT_TIMESTAMP, '백엔드 API 개발', '2024-05-31', 'API 구현', 2, '2024-03-02', 1, '1', '1', false),
    ('5', CURRENT_TIMESTAMP, '테스트 계획 수립', '2024-06-15', '테스트 전략', 3, '2024-06-01', 3,  NULL, '2', false),
    ('6', CURRENT_TIMESTAMP, '단위 테스트 실행', '2024-07-15', '모듈 테스트', 2, '2024-06-16', 3, '2', '2', false),
    ('7', CURRENT_TIMESTAMP, '데이터 마이그레이션', '2024-08-31', '레거시 데이터 이전', 1, '2024-08-01', 3,  NULL, '3', false),
    ('8', CURRENT_TIMESTAMP, '사용자 매뉴얼 작성', '2024-09-30', '매뉴얼 제작', 3, '2024-09-01', 3, NULL, '4', false),
    ('9', CURRENT_TIMESTAMP, 'AI 모델 훈련', '2024-10-31', '챗봇 AI 학습', 1, '2024-10-01', 3,  NULL, '5', false)
    ON CONFLICT (task_pk) DO NOTHING;

INSERT INTO project_team (project_team_pk, create_date, responsibility, update_date, user_pk, project_pk)
VALUES
    ('1', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, '1'),
    ('2', CURRENT_TIMESTAMP, 2, CURRENT_TIMESTAMP, 2, '1'),
    ('3', CURRENT_TIMESTAMP, 2, CURRENT_TIMESTAMP, 1, '2');