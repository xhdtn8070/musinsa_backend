package com.tikim.org.musinsa.global.exception.enums;

import org.springframework.http.HttpStatus;

public enum ErrorMessage {
    UNDEFINED_EXCEPTION("정의되지 않은 에러입니다.", HttpStatus.INTERNAL_SERVER_ERROR),
    AOP_XSS_SETTER_NO_EXSISTS_EXCEPTION("해당 필드에 SETTER가 존재하지 않습니다.", HttpStatus.BAD_REQUEST),
    AOP_XSS_FIELD_NO_EXSISTS_EXCEPTION("해당 필드에 FIELD가 존재하지 않습니다.", HttpStatus.BAD_REQUEST),

    REQUEST_INVALID_EXCEPTION("입력 값이 올바르지 않습니다.", HttpStatus.BAD_REQUEST),
    ACCESS_FORBIDDEN_AUTH_EXPIRE_EXCEPTION("ACCESS TOKEN이 EXPIRE 되었습니다.", HttpStatus.UNAUTHORIZED),
    REFRESH_FORBIDDEN_AUTH_EXPIRE_EXCEPTION("REFRESH TOKEN이 EXPIRE 되었습니다.", HttpStatus.UNAUTHORIZED),
    SMS_EXPIRED_AUTH_EXCEPTION(" 인증번호가 만료되었습니다.", HttpStatus.BAD_REQUEST),
    SMS_NONE_AUTH_EXCEPTION("번호 인증을 해주세요.", HttpStatus.BAD_REQUEST),
    SMS_SECRET_INVALID_EXCEPTION("핸드폰 인증 번호를 확인해주세요.", HttpStatus.BAD_REQUEST),
    SMS_ALREADY_AUTHED("이미 인증된 번호입니다.", HttpStatus.BAD_REQUEST),
    NO_USER_EXCEPTION("가입되지 않은 계정입니다.", HttpStatus.BAD_REQUEST),
    VALIDATION_FAIL_EXCEPTION("입력값의 조건이 올바르지 않습니다", HttpStatus.BAD_REQUEST),
    FORBIDDEN_EXCEPTION("작업을 수행할 수 있는 권한이 없습니다.", HttpStatus.UNAUTHORIZED),
    INVALID_ACCESS_EXCEPTION("존재하지 않는 게시글이거나 잘못된 접근입니다.", HttpStatus.BAD_REQUEST),
    INVALID_USER_EXCEPTION("회원 정보가 존재하지 않습니다", HttpStatus.BAD_REQUEST),
    INVALID_SEMESTER_DATE_EXCEPTION("잘못된 수강 학기입니다.", HttpStatus.BAD_REQUEST),
    PROHIBITED_ATTEMPT("수강 후기는 한 과목에 하나만 작성 가능합니다.", HttpStatus.BAD_REQUEST),
    ACCOUNT_ALREADY_SIGNED_UP("이미 가입된 계정입니다.", HttpStatus.BAD_REQUEST),
    NICKNAME_DUPLICATE("중복된 닉네임입니다.", HttpStatus.BAD_REQUEST),
    PASSWORD_FAIL("비밀번호가 틀렸습니다", HttpStatus.BAD_REQUEST),
    ACCOUNT_FAIL("아이디가 틀렸습니다", HttpStatus.BAD_REQUEST),
    AUTHORITY_NOT_EXIST("요청한 권한은 존재하지 않습니다", HttpStatus.BAD_REQUEST),
    TARGET_ARTICLE_NOT_EXIST("게시글이 존재하지 않습니다.", HttpStatus.BAD_REQUEST),
    IMAGE_FORBIDDEN_EXCEPTION("이미지의 URL이 중복됩니다.", HttpStatus.BAD_REQUEST),
    NOT_AUTHOR("작성자가 아닙니다.", HttpStatus.BAD_REQUEST),
    TARGET_ARTICLE_COMMENT_NOT_EXIST("댓글이 존재하지 않습니다", HttpStatus.BAD_REQUEST),
    REGION_INVALID("지역의 입력값이 잘못되었습니다.", HttpStatus.BAD_REQUEST),

    //토큰 관련
    FORGERY_TOKEN("위변조된 토큰입니다.", HttpStatus.UNAUTHORIZED),
    NOT_FOUND_TOKEN("토큰이 존재하지 않습니다.", HttpStatus.UNAUTHORIZED),
    INVALID_TOKEN_FORMAT("토큰 형식이 알맞지 않습니다.", HttpStatus.UNAUTHORIZED),
    INVALID_TOKEN_TYPE("토큰 타입이 맞지 않습니다. refresh, access 토큰을 잘못 넣은 것은 아닌지 확인해주세요.", HttpStatus.UNAUTHORIZED),
    INVALID_ACCESS_TOKEN("ACCESS TOKEN이 VALID하지 않습니다.", HttpStatus.UNAUTHORIZED),
    INVALID_REFRESH_TOKEN("REFRESH TOKEN이 VALID하지 않습니다.", HttpStatus.UNAUTHORIZED),
    EXPIRED_TOKEN("토큰이 만료되었습니다.", HttpStatus.UNAUTHORIZED),
    EXPIRED_REFRESH_TOKEN("리프레쉬 토큰이 만료되었습니다.", HttpStatus.UNAUTHORIZED),
    EXPIRED_OAUTH_TOKEN("OAuth 토큰이 만료되었습니다.", HttpStatus.UNAUTHORIZED),
    NOT_FOUND_OAUTH_TOKEN("OAuth 토큰이 존재하지 않습니다.", HttpStatus.UNAUTHORIZED),
    INVALID_OAUTH_TOKEN("OAuth 토큰 형식이 알맞지 않습니다.", HttpStatus.UNAUTHORIZED),

    KAKAO_OAUTH_TOKEN_RENEW("OAuth 토큰 형식이 알맞지 않습니다.", HttpStatus.UNAUTHORIZED),

    //유저 관련
    NOT_FOUND_USER("존재하지 않는 사용자 계정입니다.", HttpStatus.BAD_REQUEST),
    USER_PASSWORD_NOT_CORRECT("비밀번호 오류입니다.", HttpStatus.BAD_REQUEST),
    REFRESH_INVALID_EXCEPTION("올바르지 않은 refresh token입니다.", HttpStatus.BAD_REQUEST),
    OAUTH_ENCRYPT_NOT_CORRECT("SNS 유저 정보가 올바르지 않습니다.", HttpStatus.BAD_REQUEST),
    PRIVACY_POLICY_DISAGREE("개인정보 활용 동의가 되지 않았습니다.", HttpStatus.BAD_REQUEST),
    DUPLICATE_USER("이미 가입된 유저입니다.", HttpStatus.BAD_REQUEST),
    TOSS_PAYMENTS_ERROR("토스 페이먼츠 모듈에서 에러가 발생했습니다.", HttpStatus.BAD_REQUEST),

    //아이템 관련
    NOT_FOUND_CODE("잘못된 코드입니다. 다시 한번 확인해주세요.", HttpStatus.BAD_REQUEST),
    NOT_FOUND_ITEM("해당 아이템이 존재하지 않습니다.", HttpStatus.NOT_FOUND),
    DUPLICATED_ITEM("이미 보유중인 상품 입니다.", HttpStatus.BAD_REQUEST),
    MISMATCH_ITEM_TYPE("아이템 지급 방식이 올바르지 않습니다.", HttpStatus.BAD_REQUEST),
    EXPIRED_ITEM("아이템 유효 기간이 만료되었습니다.", HttpStatus.BAD_REQUEST),
    NOT_ENOUGH_ITEM("남은 아이템 수량이 없습니다.", HttpStatus.BAD_REQUEST),
    FORGED_ITEM_DATE("아이템 데이터가 위변조 되었습니다.", HttpStatus.BAD_REQUEST),
    NOT_FOUND_NOTIFICATION("존재하지 않는 알림입니다.", HttpStatus.BAD_REQUEST),
    FORBIDDEN_READ_NOTIFICATION("알림을 읽을 권한이 없습니다.", HttpStatus.BAD_REQUEST),

    INVALID_SNS_TYPE("SNS TYPE이 잘못 되었습니다.", HttpStatus.BAD_REQUEST),
    OAUTH_TOKEN_FORMAT_INVALID_EXCEPTION("oAuth 토큰 정보가 올바르지 않습니다.", HttpStatus.BAD_REQUEST),

    // 클래스 할인
    CLASS_DISCOUNT_CONFILCT("", HttpStatus.BAD_REQUEST),
    NOT_SALE_CLASS("수강 가능한 클래스가 아닙니다.", HttpStatus.BAD_REQUEST),

    CLASS_ALREADY_ENROLMENT("이미 구입한 강의입니다.", HttpStatus.BAD_REQUEST),
    OAUTH_ACCESS_FORBIDDEN_AUTH_INVALID_EXCEPTION("oAuth 토큰이 valid하지 않습니다", HttpStatus.BAD_REQUEST),
    CATEGORY_HAS_CHILDREN_EXCEPTION("카테고리의 하부 카테고리가 존재합니다.", HttpStatus.BAD_REQUEST),
    CATEGORY_HAS_RELATION_ENTITY_EXCEPTION("카테고리를 사용하는 관계 엔티티가 존재합니다.", HttpStatus.BAD_REQUEST),
    ENTITY_NULL_POINTER_EXCEPTION("DATA ENTITY의 NULL 여부를 확인해주세요", HttpStatus.BAD_REQUEST),
    PARENT_NULL("미성년자인 경우 학부모의 정보가 필요합니다. 부모 정보가 등록되지 않았습니다.", HttpStatus.BAD_REQUEST),
    PARENT_SMS_NULL("학부모의 휴대폰 인증 정보는 비워둘 수 없습니다.", HttpStatus.BAD_REQUEST),
    PARENT_SMS_SECRET_INVALID_EXCEPTION("학부모 휴대폰 인증 번호를 확인해주세요.", HttpStatus.BAD_REQUEST),
    USER_NOT_CORRECT("작성자 혹은 사용자가 올바르지 않습니다.", HttpStatus.BAD_REQUEST),
    DO_NOT_HAVE_PERMISSION("해당 요청에 대한 권한이 없습니다.", HttpStatus.BAD_REQUEST),
    SECTION_HAS_CHILDREN_EXCEPTION("해당 섹션을 사용하는 하부 Paragraph가 존재합니다.", HttpStatus.BAD_REQUEST),
    FILE_HAS_CHILDREN_EXCEPTION("해당 파일을 사용하는 곳이 존재합니다.", HttpStatus.BAD_REQUEST),
    USER_DONT_HAVE_ACCESES("해당 사용자에게 접근 권한이 없습니다.", HttpStatus.BAD_REQUEST),
    HASHTAG_HAS_CHILDREN_EXCEPTION("해당 해시태그를 사용하는 곳이 존재합니다.", HttpStatus.BAD_REQUEST),
    KAKAO_TOKEN_NULL("카카오 토큰이 올바르게 발급되지 않았습니다.", HttpStatus.BAD_REQUEST),
    KAKAO_USER_INFO_NULL("카카오 유저 정보를 받아오지 못했습니다.", HttpStatus.BAD_REQUEST),
    PRICE_DOES_NOT_MATCH("주문서 가격과 결제 가격이 일치하지 않습니다.", HttpStatus.BAD_REQUEST),
    INVALID_CLASS_EXCEPTION("해당 강의가 존재하지 않습니다.", HttpStatus.BAD_REQUEST),
    INVALID_CART_ID_EXCEPTION("잘못된 장바구니 항목입니다.", HttpStatus.BAD_REQUEST),
    INVALID_COUPON_EXCEPTION("존재하지 않는 쿠폰 입니다.", HttpStatus.BAD_REQUEST),
    EXPIRED_COUPON_EXCEPTION("기한이 만료된 쿠폰입니다.", HttpStatus.BAD_REQUEST),
    INVALID_MINIMUM_PRICE_COUPON("최소 주문 금액 조건에 일치하지 않습니다.", HttpStatus.BAD_REQUEST),
    DUPLICATED_COUPON_CODE_EXCEPTION("쿠폰 코드가 중복되었습니다.", HttpStatus.BAD_REQUEST),
    DUPLICATED_ROLE_EXCEPTION("같은 이름의 역할이 있습니다.", HttpStatus.BAD_REQUEST),
    FILE_TYPE_EXCEPTION("요구하는 파일의 TYPE이 아닙니다.", HttpStatus.BAD_REQUEST),
    LECTURE_FILE_NULL_EXCEPTION("Lecture - file은 해당 조건에서 NULL일 수 없습니다.", HttpStatus.BAD_REQUEST),
    LECTURE_MISSION_NULL_EXCEPTION("Lecture - file은 해당 조건에서 NULL일 수 없습니다", HttpStatus.BAD_REQUEST),
    STILL_IN_DEVELOPMENT("개발 진행 중인 항목입니다.", HttpStatus.BAD_REQUEST),
    NOT_ADULT("성인이 아닙니다.", HttpStatus.BAD_REQUEST),
    NOTIFICATION_EXCEPTION("잘못된 알림 신청 요청입니다.", HttpStatus.BAD_REQUEST),
    NOT_FOUND_PRODUCT_PACKAGE("패키지 정보를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),

    NOT_FOUND_PRODUCT_PACKAGE_CATEGORY("패키지 카테고리 정보를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),

    INVALID_PRODUCT_PACKAGE_TYPE("패키지 타입이 일치하지 않습니다.", HttpStatus.NOT_FOUND),

    INVALID_USER_COUPON_TYPE("유저 쿠폰 타입이 일치하지 않습니다.", HttpStatus.NOT_FOUND),

    NOT_FOUND_CHECKOUT("주문서 정보를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    NOT_DONE_PAYMENT("결제가 상태가 올바르게 변경되지 않았습니다.", HttpStatus.BAD_REQUEST),
    REPLY_ENTITY_IS_NOT_ROOT("해당 댓글 Entity가 루트가 아닙니다.", HttpStatus.BAD_REQUEST),
    MISSION_REPLY_REQUIRE_CHECK("미션 댓글은 강의 수강 후 작성할 수 있습니다.", HttpStatus.BAD_REQUEST),
    // Mapper 오류
    NOT_FOUND_MAPPER("지정된 매퍼를 찾을 수 없습니다.", HttpStatus.BAD_REQUEST),
    // 객체가 PUBLIC  오류
    ENTITY_IS_PUBLIC("해당 항목이 PUBLIC입니다. PRIVATE로 변경 후 재시도해주세요.", HttpStatus.BAD_REQUEST),
    SECRET_NOT_MATCH("secret 키가 일치하지 않습니다.", HttpStatus.BAD_REQUEST),
    PACKAGE_MAX_USER_EXCEPTION("수업 최대 인원이 초과했습니다.", HttpStatus.BAD_REQUEST),
    CLASS_ROOM_MAX_USER_EXCEPTION("수업 최대 인원이 초과했습니다.", HttpStatus.BAD_REQUEST),
    CLASS_ROOM_LECTURE_IS_PRIVATE("해당 클래스 룸 강의는 비공개입니다.", HttpStatus.BAD_REQUEST),
    CLASS_ROOM_IS_PRIVATE("해당 클래스 룸 강의는 비공개입니다.", HttpStatus.BAD_REQUEST),
    CLASS_ROOM_COMMUNITY_IS_PRIVATE("해당 클래스 룸 게시글은 비공개입니다.", HttpStatus.BAD_REQUEST),
    CLASS_ROOM_COMMUNITY_CAN_NOT_BE_READ("해당 클래스 룸 게시글은 읽을 수 없습니다.", HttpStatus.BAD_REQUEST),
    CLASS_ROOM_LECTURE_IS_NOT_ACTIVE("해당 클래스 룸 강의는 비활성 상태입니다.", HttpStatus.BAD_REQUEST),
    NOT_CORRECT_CLASS_ROOM_AND_CLASS_ROOM_CHAPTER("클래스 룸과 클래스 룸 챕터 관계가 올바르지 않습니다.", HttpStatus.BAD_REQUEST),
    NOT_CORRECT_CLASS_ROOM_CHAPTER_AND_CLASS_ROOM_LECTURE("클래스 룸 챕터와 클래스 룸 강의 관계가 올바르지 않습니다.", HttpStatus.BAD_REQUEST),
    ADMIN_NOT_HAVE_SERVICE_ACCOUNT("어드민 계정과 서비스 계정을 연결해주세요.\nDB에서 연결해주면 됩니다. (토니, 에녹)", HttpStatus.BAD_REQUEST),
    DUPLICATE_NOTIFICATION("중복된 알림 신청 요청입니다.", HttpStatus.BAD_REQUEST),
    NOT_FOUNT_DEFAULT_CHAPTER("기본 챕터를 찾을 수 없습니다.", HttpStatus.BAD_REQUEST),
    NOT_FOUNT_DEFAULT_LECTURE("기본 강의를 찾을 수 없습니다.", HttpStatus.BAD_REQUEST),
    NOT_FOUND_FILE("해당 파일을 찾을 수 없습니다.", HttpStatus.BAD_REQUEST),
    REPLY_ROOT_IS_NOT_ROOT("해당 루트 댓글은 상위에 루트를 가지고 있습니다.", HttpStatus.BAD_REQUEST),
    PACKAGE_DISCOUNT_CONFLICT("페키지 할인 기간에 충돌이 있습니다.", HttpStatus.BAD_REQUEST),
    PACKAGE_EXIST("해당 코스에 할당된 패키지가 존재합니다. 패키지를 먼저 삭제해주세요", HttpStatus.BAD_REQUEST),
    CLASSROOM_IDS_IS_OVERATE("클래스룸 IDS 사이즈가 너무 큽니다.", HttpStatus.BAD_REQUEST),
    INVALID_COUPON_TYPE("발급 불가능한 쿠폰입니다.", HttpStatus.BAD_REQUEST),
    COUPON_ISSUE_AMOUNT_LIMIT("발급 가능 갯수를 초과했습니다.", HttpStatus.BAD_REQUEST),
    COUPON_ISSUE_TIME_LIMIT("발급 가능 기한이 아닙니다.", HttpStatus.BAD_REQUEST),
    COUPON_DUPLICATE("이미 발급된 쿠폰입니다.", HttpStatus.BAD_REQUEST),
    INVALID_COUPON_CODE("잘못된 쿠폰 번호입니다.", HttpStatus.NOT_FOUND),
    CLASS_ROOM_REVIEW_IS_ALREADY_SKIPPED("해당 리뷰는 이미 스킵되었습니다.", HttpStatus.BAD_REQUEST),
    CLASS_ROOM_REVIEW_CAN_NOT_SKIP("해당 리뷰는 스킵될 수 없는 상태입니다.", HttpStatus.BAD_REQUEST),
    INVALID_COUPON_EXPIRED_AT("쿠폰 만료 기간과 쿠폰 발급 마감 기간을 확인해주세요.", HttpStatus.BAD_REQUEST),
    ALREADY_FREE_TRIAL("이미 무료 체험을 신청했거나 무료 체험이 완료된 사용자입니다.", HttpStatus.BAD_REQUEST),
    INVALID_ORDER_SUBSCRIPTION("구매할 수 있는 수강권이 아닙니다. 수강권 타입이 올바른지 확인해주세요.", HttpStatus.BAD_REQUEST),
    IAMPORT_TOKEN_ERROR("결제 모듈 에러 (아임포트 토큰 발급 실패)", HttpStatus.INTERNAL_SERVER_ERROR),
    IAMPORT_SERVER_ERROR("아임포트 서버가 응답하지 않습니다.", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_PAYMENT_INFO("변조된 결제 정보 입니다.", HttpStatus.BAD_REQUEST),
    FINAL_PRICE_CANNOT_BE_EQUAL_TO_OR_HIGHER_THAN_THE_PREVIOUS_PRICE("최종 가격은 이전 가격과 같거나 높을 수 없습니다..", HttpStatus.BAD_REQUEST),
    ALREADY_SUBSCRIBE("이미 구독중인 사용자입니다.", HttpStatus.BAD_REQUEST),
    BAD_INPUT_DATA("입력 정보를 확인해주세요", HttpStatus.BAD_REQUEST),
    INVALID_FILE_TYPE("적용할 수 없는 파일 타입이 아닙니다. 파일 타입이 올바른지 확인해주세요.", HttpStatus.BAD_REQUEST),
    INVALID_FILE_EXT("적용할 수 없는 파일 타입이 아닙니다. 파일 타입이 올바른지 확인해주세요.", HttpStatus.BAD_REQUEST),
    CHECKOUT_ENROLLMENT_IS_REQUIRED("해당 과정은 checkout이 존재하는 enrollment가 요구됩니다. 확인 후 다시 진행해주세요.", HttpStatus.BAD_REQUEST),

    CHECKOUT_ENROLLMENT_IS_NOT_REQUIRED("해당 과정은 checkout이 존재하지 않은 enrollment만 사용 가능합니다.확인 후 다시 진행해주세요.", HttpStatus.BAD_REQUEST),

    ENROLLMENT_IS_INVALID("Enrollment를 다시 확인해주세요.", HttpStatus.BAD_REQUEST),
    UPDATE_ALREADY_SEND_MESSAGE("이미 발송된 메세지는 수정할 수 없습니다.", HttpStatus.BAD_REQUEST),

    INVALID_USER_COUPON_EXCEPTION("올바르지 않은 쿠폰입니다. 해당 문제가 지속적으로 발생하면 문의주시기 바랍니다.", HttpStatus.BAD_REQUEST),

    KAKAO_TOKEN_NOT__POINTER_EXCEPTION("DATA ENTITY의 NULL 여부를 확인해주세요", HttpStatus.BAD_REQUEST),

    ALARM_DUPLICATED("이미 존재하는 알림톡 예약이 존재합니다.", HttpStatus.BAD_REQUEST),

    ALARM_TYPE_IS_INVALID("알림톡 타입이 올바르지 않습니다.", HttpStatus.BAD_REQUEST),

    POINT_INSUFFICIENT("사용가능한 포인트보다 사용하려는 포인트가 많습니다. 포인트가 부족합니다.", HttpStatus.BAD_REQUEST),

    INVALID_POINT_AMOUNT("최소 결제 금액을 넘는 포인트는 사용할 수 없습니다.", HttpStatus.BAD_REQUEST),

    INVALID_ZERO_PAY("해당 결제는 제로 페이가 아닙니다.", HttpStatus.BAD_REQUEST),

    UNAVAILABLE_ZERO_PAY("해당 결제는 제로 페이를 사용할 수 없습니다.", HttpStatus.BAD_REQUEST),

    POINT_OVERUSE("포인트를 초과해서 사용할 수 없습니다.", HttpStatus.BAD_REQUEST),

    REFERRAL_CODE_IS_INVALID("추천인 코드가 올바르지 않습니다.", HttpStatus.BAD_REQUEST),

    REFERRAL_CODE_ONCE_ONLY("추천인 등록은 한 번만 사용할 수 있습니다.", HttpStatus.BAD_REQUEST),

    SELF_REFERRAL_CODE_NOT_ALLOWED("본인의 추천인 코드를 등록할 수 없습니다.", HttpStatus.BAD_REQUEST),

    COUPON_CATEGORY_NOT_DELETABLE("쿠폰 카테고리가 삭제할 수 없습니다.", HttpStatus.BAD_REQUEST),

    COUPON_NOT_DELETABLE("쿠폰을 삭제할 수 없습니다.", HttpStatus.BAD_REQUEST),

    COUPON_ALREADY_USED("이미 사용된 쿠폰입니다.", HttpStatus.BAD_REQUEST),
    COLLECTION_NOT_DELETABLE("컬렉션을 삭제할 수 없습니다.", HttpStatus.BAD_REQUEST),

    PACKAGE_CATEGORY_NOT_DELETABLE("패키지 카테고리를 삭제할 수 없습니다.", HttpStatus.BAD_REQUEST),

    PACKAGE_CATEGORY_NOT_UPDATABLE("패키지 카테고리를 수정할 수 없습니다.", HttpStatus.BAD_REQUEST),

    PACKAGE_NOT_DELETABLE("패키지를 삭제할 수 없습니다.", HttpStatus.BAD_REQUEST),

    PACKAGE_NOT_UPDATABLE("패키지를 수정할 수 없습니다.", HttpStatus.BAD_REQUEST),

    SALE_START_OUT_OF_ROOT_RANGE("해당 패키지(카테고리)의 판매 시작일이 상위 카테고리의 판매 시작일을 벗어납니다.", HttpStatus.BAD_REQUEST),

    SALE_END_OUT_OF_ROOT_RANGE("해당 패키지(카테고리)의 판매 종료일이 상위 카테고리의 판매 종료일을 벗어납니다.", HttpStatus.BAD_REQUEST),

    FEATURE_NOT_AVAILABLE("현재 제공중이지 않은 기능입니다.", HttpStatus.BAD_REQUEST),

    FILE_NAME_NULL_POINTER_EXCEPTION("파일 이름이 NULL입니다.", HttpStatus.BAD_REQUEST),

    WEBSOCKET_TOPIC_INVALID("올바르지 않은 웹소켓 토픽입니다.", HttpStatus.BAD_REQUEST),

    CHAPTER_PREP_URL_IS_BLANK("챕터 prep url이 비어있습니다.", HttpStatus.BAD_REQUEST),

    CHAPTER_LIVE_AT_IS_NULL("챕터 라이브 시간이 비어있습니다.", HttpStatus.BAD_REQUEST),
    ;



    String errorMessage;
    HttpStatus httpStatus;

    ErrorMessage(String errorMessage, HttpStatus httpStatus) {
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }


}
