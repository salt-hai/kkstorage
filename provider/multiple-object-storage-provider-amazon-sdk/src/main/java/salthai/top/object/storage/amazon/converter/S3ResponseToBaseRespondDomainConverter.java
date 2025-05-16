package salthai.top.object.storage.amazon.converter;

import salthai.top.object.storage.core.domain.base.BaseResponseDomain;
import salthai.top.object.storage.core.model.converter.BaseConverter;
import software.amazon.awssdk.services.s3.model.S3Response;

/**
 * S3Response 是s3响应基类
 *
 * @author Kuang HaiBo 2025/5/16 15:32
 */
public abstract class S3ResponseToBaseRespondDomainConverter<Source extends S3Response, Target extends BaseResponseDomain>
		implements BaseConverter<Source, Target> {

	/**
	 * 参数准备 即由来源对象的一些属性设置到目标对象
	 * @param source 源对象
	 * @param instance 转换后的对象
	 */
	@Override
	public void prepare(Source source, Target instance) {
		source.sdkHttpResponse().headers().forEach((s, strings) -> instance.addHeader(s, strings.get(0)));
	}

}
